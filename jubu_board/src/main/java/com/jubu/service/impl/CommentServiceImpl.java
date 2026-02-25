package com.jubu.service.impl;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubu.dto.CommentDTO;
import com.jubu.entity.Comment;
import com.jubu.repository.CommentRepository;
import com.jubu.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository; 

    /* 댓글 저장 */
    @Override
    @Transactional
    public void registerComment(CommentDTO commentDTO) {
    	Comment entity = new Comment();
        BeanUtils.copyProperties(commentDTO, entity);
        commentRepository.save(entity); // insert 대신 save!
    }

    /* 댓글 조회 */
    @Override
    public List<CommentDTO> getCommentsByBoard(Integer boardId) {
    	List<Comment> entities = commentRepository.findByBoardId(boardId); 
        
        Map<Integer, CommentDTO> dtoMap = new HashMap<>();
        List<CommentDTO> rootComments = new ArrayList<>();

        // 2. DTO 변환 및 맵 구성
        for (Comment entity : entities) {
            CommentDTO dto = new CommentDTO();
            BeanUtils.copyProperties(entity, dto);
            dtoMap.put(dto.getCommentId(), dto);
            
            // 3. 트리 구조 조립
            if (entity.getParentId() == null) {
                rootComments.add(dto); // 부모 없는 애들은 루트로!
            }
        }

        // 자식 댓글들 연결
        for (Comment entity : entities) {
            if (entity.getParentId() != null) {
                CommentDTO parentDto = dtoMap.get(entity.getParentId());
                CommentDTO childDto = dtoMap.get(entity.getCommentId());
                if (parentDto != null) {
                    parentDto.getChildren().add(childDto);
                }
            }
        }
        return rootComments;
    }

    /* 댓글 수정 */
    @Override
    @Transactional
    public void modifyComment(CommentDTO commentDTO) {
    	Comment entity = commentRepository.findById(commentDTO.getCommentId())
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
        
        entity.setContent(commentDTO.getContent());
        // save를 굳이 안 해도 @Transactional 덕분에 더티 체킹으로 업데이트 되지만, 
        // 명시적으로 작성
        commentRepository.save(entity);
    }

    /* 댓글 삭제 */
    @Override
    @Transactional
    public void removeComment(Integer commentId) {
        Comment entity = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
        
        entity.delete();
    }
}
package com.example.success_tutor.domain.reply;

import com.example.success_tutor.domain.reply.dto.CreateReplyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("reply")
public class ReplyController {

    private final ReplyService replyService;

   /**
   * @methodName : postReply
   * @param : CreateReplyRequestDto dto
   * @return : ResponseEntity<>(HttpStatus.OK)
   * @Description: CreateReplyRequestDto를 받아 저장하는 로직입니다.
   * @note:
   **/
    @PostMapping()
    public ResponseEntity<?> postReply(@RequestBody CreateReplyRequestDto dto){
        replyService.createReply(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

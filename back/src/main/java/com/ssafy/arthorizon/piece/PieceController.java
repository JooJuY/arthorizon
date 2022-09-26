package com.ssafy.arthorizon.piece;

import com.ssafy.arthorizon.piece.dto.PieceDto;
import com.ssafy.arthorizon.piece.dto.PiecePageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pieces")
public class PieceController {

    private final PieceService pieceService;

    public PieceController(PieceService pieceService) {
        this.pieceService = pieceService;
    }

    // 작품 목록 최신순 조회 페이지네이션
    @GetMapping("/recent")
    public ResponseEntity<PiecePageDto> pieceListRecent(@RequestParam("page") int page){
        PiecePageDto piecePageDto = pieceService.pieceListService(page, "recent");
        if(piecePageDto.getResult()== PieceDto.PieceResult.SUCCESS){
            return new ResponseEntity<>(piecePageDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(piecePageDto, HttpStatus.BAD_REQUEST);
        }
    }


    // 작품 목록 북마크순 조회 페이지네이션
    @GetMapping("/popular")
    public ResponseEntity<PiecePageDto> pieceListPopular(@RequestParam("page") int page){
        PiecePageDto piecePageDto = pieceService.pieceListService(page, "popular");
        if(piecePageDto.getResult()== PieceDto.PieceResult.SUCCESS){
            return new ResponseEntity<>(piecePageDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(piecePageDto, HttpStatus.BAD_REQUEST);
        }
    }

    // 단일 작품 조회
    @GetMapping("/{pieceSeq}")
    public ResponseEntity<PieceDto> pieceOne(@PathVariable Long pieceSeq){
        PieceDto pieceDto = pieceService.pieceOne(pieceSeq);
        if(pieceDto.getResult()== PieceDto.PieceResult.SUCCESS){
            return new ResponseEntity<>(pieceDto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(pieceDto,HttpStatus.BAD_REQUEST);
        }
    }

    // 태그 조회
}

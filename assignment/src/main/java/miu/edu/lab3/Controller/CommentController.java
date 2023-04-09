package miu.edu.lab3.Controller;


import miu.edu.lab3.Dto.CommentDto;
import miu.edu.lab3.Service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comment")
public class CommentController {
    CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    @GetMapping
    public List<CommentDto> getAll(){
        return commentService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CommentDto getById(@PathVariable int id){
        return commentService.getById(id);
    }

//    @DeleteMapping(value = "/delete/{id}")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id){

        commentService.delete(id);
    }

    @PostMapping
    public void save(@RequestBody CommentDto commentDto){
        commentService.save(commentDto);
    }


}

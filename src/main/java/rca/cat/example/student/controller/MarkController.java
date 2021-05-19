package rca.cat.example.student.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import rca.cat.example.student.domain.Mark;
import rca.cat.example.student.dto.MarkDTO;
import rca.cat.example.student.repository.MarkRepository;


import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MarkController {

    @Autowired
    private MarkRepository markRepository;

    private ModelMapper modelMapper = new ModelMapper();

    //Add mark
    @PostMapping("/mark")
    public MarkDTO addMark(@RequestBody MarkDTO markDTO) throws ParseException {
        Mark mark = convertToEntity(markDTO);
        return convertToDto(markRepository.save(mark));
    }

    //Get mark by Id
    @GetMapping("/mark/{id}")
    public Mark getMarkById(@PathVariable Long id){
        return markRepository.findById(id)
                .orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    //Get all marks
    @GetMapping("/marks")
    public List<Mark> getALlMarks(){
        return markRepository.findAll();
    }

    //Update mark by Id
    @PutMapping("/mark/{id}")
    public ResponseEntity<Mark> updateMarkById(@PathVariable Long id, @RequestBody Mark mark){
        Optional<Mark> MarkData = markRepository.findById(id);

        if(MarkData.isPresent()){
            Mark _mark = MarkData.get();
            _mark.setId(mark.getId());
            _mark.setStudent(mark.getStudent());
            _mark.setCourse(mark.getCourse());
            _mark.setScore(mark.getScore());
            _mark.setMaximum(mark.getMaximum());

            return new ResponseEntity<>(markRepository.save(_mark),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete mark by ID
    @DeleteMapping("/mark/{id}")
    public void deleteMarkById(@PathVariable Long id){
        markRepository.deleteById(id);
    }

    private MarkDTO convertToDto(Mark mark) {
        MarkDTO markDto = modelMapper.map(mark, MarkDTO.class);
        markDto.setStudentId(mark.getStudent().getId());
        markDto.setCourseId(mark.getCourse().getId());
        return markDto;
    }

    private Mark convertToEntity(MarkDTO markDTO) throws ParseException {
        Mark mark = modelMapper.map(markDTO, Mark.class);
        mark.setId(markDTO.getId());

        return mark;
    }


}
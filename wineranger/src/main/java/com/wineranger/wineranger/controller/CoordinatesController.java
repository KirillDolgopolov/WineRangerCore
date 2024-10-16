package com.wineranger.wineranger.controller;

import com.wineranger.wineranger.dto.auxiliars.CoordinatesDTO;
import com.wineranger.wineranger.service.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/{languageId}/coordinates")
public class CoordinatesController {
    private final CoordinatesService coordinatesService;

    @Autowired
    public CoordinatesController(CoordinatesService coordinatesService){
        this.coordinatesService = coordinatesService;
    }

    @GetMapping("/all_valid")
    public ResponseEntity<List<CoordinatesDTO>> getAllAndValid(){
        try{
            return new ResponseEntity<>(coordinatesService.getAllAndValid(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CoordinatesDTO>> getAll(){
        try{
            return new ResponseEntity<>(coordinatesService.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordinatesDTO> getById (@PathVariable Long id) {
        try{
            return new ResponseEntity<>(coordinatesService.getById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/new")
    public ResponseEntity<CoordinatesDTO> create (@RequestBody CoordinatesDTO dto){
        try{
            return new ResponseEntity<>(coordinatesService.create(dto), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<CoordinatesDTO> modify (@RequestBody CoordinatesDTO dto){
        try{
            return new ResponseEntity<>(coordinatesService.modify(dto), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CoordinatesDTO> delete (@PathVariable Long id){
        try{
            return new ResponseEntity<>(coordinatesService.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}

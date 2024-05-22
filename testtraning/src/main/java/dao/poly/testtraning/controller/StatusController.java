package dao.poly.testtraning.controller;

import dao.poly.testtraning.entity.Status;
import dao.poly.testtraning.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService service;

    @GetMapping("")
    public ResponseEntity<?> getAllStatus(){
        List<Status> listStatus = service.getAllStatus();
        return ResponseEntity.ok(listStatus);
    }

    @PostMapping("")
    public ResponseEntity<?> insertStatus(@RequestBody Status status){
        String kq=service.insertStatus(status);
        return ResponseEntity.ok(kq);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Status status){
        String kq=service.updateStatus(status,id);
        return ResponseEntity.ok(kq);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable Long id){
        String kq=service.deleteStatus(id);
        return ResponseEntity.ok(kq);
    }
}

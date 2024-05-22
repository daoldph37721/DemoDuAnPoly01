package dao.poly.testtraning.service.impl;

import dao.poly.testtraning.entity.Status;
import dao.poly.testtraning.repository.StatusRepository;
import dao.poly.testtraning.service.StatusService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class StatusServiceImpl implements StatusService {

    private ArrayList<Status> listStatus = new ArrayList<>();

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.getAllStatus();
    }

    @Override
    public String insertStatus(Status status) {
        int x = statusRepository.insertStatus(status.getStatusName());
        if (x > 0) return "Da them thanh cong";
        return "Da them that bai";
    }

    @Override
    public String updateStatus(Status status, Long id) {
        int x = statusRepository.updateStatus(status.getStatusName(),id);
        if (x > 0) return "Da cap nhat thanh cong";
        return "Da cap nhat that bai";
    }

    @Override
    public String deleteStatus(Long id) {
        int x = statusRepository.deleteStatus(id);
        if (x > 0) return "Da xoa thanh cong";
        return "Da xoa that bai";
    }
}

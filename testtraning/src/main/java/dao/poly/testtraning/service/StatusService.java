package dao.poly.testtraning.service;

import dao.poly.testtraning.entity.Status;

import java.util.List;

public interface StatusService {

    public List<Status> getAllStatus();

    public String insertStatus(Status status);

    public String updateStatus(Status status, Long id);

    public String deleteStatus(Long id);

}

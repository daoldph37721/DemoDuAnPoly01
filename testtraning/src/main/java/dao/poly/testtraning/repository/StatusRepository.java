package dao.poly.testtraning.repository;

import dao.poly.testtraning.entity.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {

    @Query(value = "select * from status", nativeQuery = true)
    List<Status> getAllStatus();

    @Modifying
    @Transactional
    @Query(value = "insert into status(status_name) values(:statusName)", nativeQuery = true)
    int insertStatus(@Param("statusName") String statusName);

    @Modifying
    @Transactional
    @Query(value = "update status set status_name = :statusName where id = :id", nativeQuery = true)
    int updateStatus(@Param("statusName") String statusName, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM status WHERE id = :id", nativeQuery = true)
    int deleteStatus( @Param("id") Long id);
}

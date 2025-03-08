package main.dhstudios.cn.master.repository;

import com.master.model.ServerStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ServerRepository extends JpaRepository<ServerStatusEntity, Long> {
    Optional<ServerStatusEntity> findByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM ServerStatusEntity s WHERE s.lastHeartbeat < ?1")
    int deleteExpiredServers(LocalDateTime cutoffTime);
}
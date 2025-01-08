package com.example.Action.Dao;

import com.example.Action.Entity.GroupAndDivision;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class GroupAndDivisionDao {

    private final JdbcTemplate jdbcTemplate1;

    public GroupAndDivisionDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }


    public GroupAndDivision addGpAndDv(GroupAndDivision groupAndDivision) {
        LocalDateTime date =LocalDateTime.now();
        String sql = "insert into groupanddivision(sequence_id,group_name,division_name,spoc_name,created_by,is_active,created_date,updated_date)values(?,?,?,?,?,?,?,?)";
         jdbcTemplate1.update(sql,
                            groupAndDivision.getSequenceId(),
                            groupAndDivision.getGroupName()
                             ,groupAndDivision.getDivisionName(),
                              groupAndDivision.getSpocName(), groupAndDivision.getCreatedBy()
                             ,groupAndDivision.getIsActive(),date,date);
      return groupAndDivision;
    }

    public String deletebyGroupname(String groupname) {
        String sql = "delete from groupanddivision where group_name = ?";
        jdbcTemplate1.update(sql,groupname);
        return "deleted successfully";
    }

    public String deletebyDivisionname(String divisionName) {
        String sql = "delete from groupanddivision where division_name = ?";
        jdbcTemplate1.update(sql,divisionName);
        return "deleted successfully";

    }

    public String deletebySpocname(String spocName) {
        String sql = "delete from groupanddivision where spoc_name = ?";
        jdbcTemplate1.update(sql,spocName);
        return "deleted successfully";

    }

    public String updateGroupAndDivision(Long sequenceId, GroupAndDivision groupAndDivision) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "UPDATE groupanddivision SET group_name = ?, division_name = ?, spoc_name = ?, updated_date = ? WHERE sequence_id = ?";
        jdbcTemplate1.update(
                sql,
                groupAndDivision.getGroupName(),
                groupAndDivision.getDivisionName(),
                groupAndDivision.getSpocName(),
                date,
                sequenceId
        );
        return "Updated successfully";
    }

}

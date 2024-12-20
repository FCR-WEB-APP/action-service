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
        String sql = "insert into groupanddivision(groupname,divisionname,spocname,createdBy,isActive,createdDate,updatedDate)";
         jdbcTemplate1.update(sql,
                            groupAndDivision.getGroupName()
                             ,groupAndDivision.getDivisionName(),
                              groupAndDivision.getSpocName(), groupAndDivision.getCreatedBy()
                             ,groupAndDivision.getIsActive(),date,date);
      return groupAndDivision;
    }

    public String deletebyGroupname(String groupname) {
        String sql = "delete from groupanddivision where groupname = ?";
        jdbcTemplate1.update(sql,groupname);
        return "deleted successfully";
    }

    public String deletebyDivisionname(String divisionName) {
        String sql = "delete from groupanddivision where divisionname = ?";
        jdbcTemplate1.update(sql,divisionName);
        return "deleted successfully";

    }

    public String deletebySpocname(String spocName) {
        String sql = "delete from groupanddivision where spocname = ?";
        jdbcTemplate1.update(sql,spocName);
        return "deleted successfully";

    }

    public String updateGroupAndDivision(GroupAndDivision groupAndDivision) {
        LocalDateTime date = LocalDateTime.now();
        String sql= "update groupanddivision set groupname = ? And divisionname = ? ,spocname = ? ,updatedDate = ?";
         jdbcTemplate1.update(sql ,
                        groupAndDivision.getGroupName(),groupAndDivision.getDivisionName()
                       ,groupAndDivision.getSpocName(),date);
         return "updated successfully";
    }
}

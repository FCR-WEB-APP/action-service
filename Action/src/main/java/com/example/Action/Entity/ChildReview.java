package com.example.Action.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ChildReview {
    private Long obligourId;
    private Long childId;
    private String assign_To;

    public Long getObligourId() {
        return obligourId;
    }

    public void setObligourId(Long obligourId) {
        this.obligourId = obligourId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public String getAssign_To() {
        return assign_To;
    }

    public void setAssign_To(String assign_To) {
        this.assign_To = assign_To;
    }
}

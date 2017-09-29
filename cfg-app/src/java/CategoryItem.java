/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcw
 */
public class CategoryItem{
    private String categoryName;
    private int required;
    private int allocated;
    private int recommended;

    public CategoryItem(String categoryName, int required, int allocated, int recommended) {
        this.categoryName = categoryName;
        this.required = required;
        this.allocated = allocated;
        this.recommended = recommended;
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRequired() {
        return required;
    }

    public void setRequired(int required) {
        this.required = required;
    }

    public int getAllocated() {
        return allocated;
    }

    public void setAllocated(int allocated) {
        this.allocated = allocated;
    }

    public int getRecommended() {
        return recommended;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }
    
}
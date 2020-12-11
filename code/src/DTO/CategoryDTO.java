/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author FelixNguyen
 */
public class CategoryDTO {
    private String name;
    
    public CategoryDTO(){
        
    }

    public CategoryDTO(String name, String type) {
        this.name = name;
        this.type = type;
    }
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString(){
        return name;
    }
}

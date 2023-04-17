package com.mycompany.projectm3.Register;

import com.mycompany.projectm3.Register.Register;

import java.util.ArrayList;

public class RegisterManager {
    private ArrayList<Register> registerList;
    public void addRegister(Register register){
        this.registerList.add(register);
    }
    public void removeRegister(Register register){
        this.registerList.remove(register);
    }
    public ArrayList<Register> getRegisterList(){
        return this.registerList;
    }
    public void setRegisterList(ArrayList<Register> registerList){
        this.registerList = registerList;
    }
}

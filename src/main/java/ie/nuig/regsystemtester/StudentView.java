/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.nuig.regsystemtester;

import ie.nuig.regsystem.Module;
import ie.nuig.regsystem.Programme;
import ie.nuig.regsystem.Student;
import java.util.ArrayList;

/**
 *
 * @author Think
 */
public class StudentView {

    public String RegisterForModule(Module selectedModule, String StudentID) {
        String msg = "";
        boolean confirmed = selectedModule.Register(StudentID);
        if (confirmed == true) {
            msg = "Registration confirmed";
        } else {
            msg = "Student already registered.";
        }
        return msg;
    }

    public static void main(String[] args) {

        Programme ITUndergrad = new Programme("IT101", "Information Technology");

        Module m1 = new Module("CT501", "Software Dev");
        Module m2 = new Module("CT432", "Machine Learning");
        Module m3 = new Module("CT332", "Systems Modeling");
        Student s1 = new Student("133324", "John A.", ITUndergrad);
        Student s2 = new Student("155224", "Mike B.", ITUndergrad);
        Student s3 = new Student("1132432", "Owen S.", ITUndergrad);

        //Adding modules to a program
        ITUndergrad.AddModule(m1);
        ITUndergrad.AddModule(m2);
        ITUndergrad.AddModule(m3);

        //Adding students to modules 
        m1.Register(s1.getID());
        m1.Register(s2.getID());
        m1.Register(s3.getID());

        System.out.println("Program:" + ITUndergrad.getName());
        ArrayList<Module> moduleList = ITUndergrad.GetModuleList();
        
        for (Module module : moduleList) {
            ArrayList registerdStudents = module.getRegisteredStudents();
            System.out.println(module.getName() + " Module:");
            if(registerdStudents.size()>0)
            {
            System.out.println("Regsitered students are:");
            System.out.println(registerdStudents);
            }
            else
                System.out.println("No students registered.");
        }
    }

}

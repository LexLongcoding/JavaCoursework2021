import java.util.*;

public class ProjectTest{

    public static void main(String[] args){

        Project p1 = new Project();
        Project p2 = new Project("Name only");
        Project p3 = new Project("Name", "Desc");

        p1.setName("New Project");
        p1.setDescription("Proj Desc");
        p1.setCost(2.3);
        System.out.println(p1.getName());
        p1.getDescription();
        
        System.out.println(p1.elevatorPitch());
        System.out.println("p1");

        
        System.out.println(p2.getName());
        p2.setDescription("p2 desc");
        p2.getDescription();
        p2.setCost(7);
        System.out.println(p2.elevatorPitch());
        System.out.println("p2");

        
        System.out.println(p3.getName());
        p3.getDescription();
        p3.setCost(10.6);
        System.out.println(p3.elevatorPitch());
        System.out.println("p3");


        ArrayList<Project> myArr = new ArrayList<Project>();
        myArr.add(p1);
        myArr.add(p2);
        myArr.add(p3);
        Portfolio pt = new Portfolio(myArr);

        System.out.println(pt.getPortfolioCost());

        pt.displayPortfolio();

        System.out.println(pt.getProjects());








    }


}
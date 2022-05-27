package com.rubix.Employees;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the Employee World" );
        
        //Employee emp = new Employee(101);
        //emp.display();
        
       
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee =  (Employee) context.getBean("employeebean");
        employee.display();
      
        
    }
}

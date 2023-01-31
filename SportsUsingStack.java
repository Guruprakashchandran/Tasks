/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.zsgpractice.stackapp;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author welcome
 */
public class SportsUsingStack 
{
    Scanner sc=new Scanner(System.in);
    public static void main(String[] args) 
    {
        SportsUsingStack obj=new SportsUsingStack();
        obj.page1();
    }

    private void page1() 
    {
        Stack<ArrayList<String>> stack=new Stack<>();
        ArrayList<String> list=new ArrayList<>();
        System.out.println("*** SPORTS LIST ***");
        list.add("1)Hockey");
        list.add("2)FootBall");
        list.add("3)Exit");
        stack.push(list);
        display(stack);
        System.out.println("Enter the sport number to continue...");
        int n=sc.nextInt();
	if(n == 3){ return;}
        page2(stack,n);
    }
    void page2(Stack<ArrayList<String>>stack,int n)
    {
        if(n==1)
        {
            int num=getHockeyDetails(stack); 
            if(num==1){page3(stack,n,num);}
            if(num==2){page3(stack,n,num);}
            if(num==3){page3(stack,n,num);}
            if(num==4){page3(stack,n,num);}
            if(num==5){page3(stack,n,num);}
            if(num==6){ stack.pop();page1();} 
        }
        else if(n==2) 
        {
            int num=getFootBallDetails(stack);
            if(num==1){page3(stack,n,num);}
            if(num==2){page3(stack,n,num);}
            if(num==3){page3(stack,n,num);}
            if(num==4){page3(stack,n,num);}
            if(num==5){page3(stack,n,num);}
            if(num==6){ stack.pop();page1();}
        }
        else
            return;
    }
    void display(Stack<ArrayList<String>> stack)
    {
        for(int i=0;i<stack.peek().size();i++)
            System.out.println(stack.peek().get(i));
    }

    private int getHockeyDetails(Stack<ArrayList<String>>stack) 
    {
        ArrayList<String> list=new ArrayList<>();
        System.out.println("*** HOCKEY PRODECU LIST ***");
        list.add("1)Hockey Sticks");
        list.add("2)Hockey Shoes");
        list.add("3)Leg Pad");
        list.add("4)Hockey Socks");
        list.add("5)Stick Bags");
        list.add("6)Back");
        stack.push(list);
        display(stack);
        System.out.println("Enter the number to continue...");
        return sc.nextInt();
    }

    private int getFootBallDetails(Stack<ArrayList<String>>stack) 
    {
        ArrayList<String> list=new ArrayList<>();
        System.out.println("*** FOOTBALL PRODECU LIST ***");
        list.add("1)FootBall");
        list.add("2)FootBall Shoes");
        list.add("3)FootBall Leg Pad");
        list.add("4)FootBall Socks");
        list.add("5)FootBall Bags");
        list.add("6)Back");
        stack.push(list);
        display(stack);
        System.out.println("Enter the number to continue...");
        return sc.nextInt();
    }

    private void page3(Stack<ArrayList<String>> stack,int sport,int num) 
    {
        ArrayList<String> list=new ArrayList();
        System.out.println("*** BRANDS ***");
        if(num==6){ stack.pop();page2(stack,sport);};
        if(sport==1 && (num==1 || num==2 || num==3 || num==4 || num==5))
        {
            list.add("1)Fenta");
            list.add("2)SNS");
            list.add("3)Grays");
            list.add("4)Mayor");
            list.add("5)Malik");
            list.add("6)Back");
            stack.push(list);
            display(stack);
            System.out.println("Enter number to continue ...");
            page4(stack,sport,num,sc.nextInt());
        }
        if(sport==2 && (num==1 || num==2 || num==3 || num==4 || num==5))
        {
            list.add("1)Adidas");
            list.add("2)Nike");
            list.add("3)Puma");
            list.add("4)Nivia");
            list.add("5)Under Armour");
            list.add("6)Back");
            stack.push(list);
            display(stack);
            System.out.println("Enter number to continue ...");
            page4(stack,sport,num,sc.nextInt());
        }
    }
    
    private void page4(Stack<ArrayList<String>> stack,int sport,int num,int n)
    {
       
        if(sport==1)
        {
          if(num==1){  
            if(n==1) System.out.println("Fenta Hockey Stick");
            if(n==2) System.out.println("SNS Hockey Stick");
            if(n==3) System.out.println("Grays Hockey Stick");
            if(n==4) System.out.println("Mayour Hockey Stick");
            if(n==5) System.out.println("Malik Hockey Stick");
            if(n==6) {stack.pop();page3(stack,sport,n);};}
          if(num==2){  
            if(n==1) System.out.println("Fenta Hockey Shoe");
            if(n==2) System.out.println("SNS Hockey Shoe");
            if(n==3) System.out.println("Grays Hockey Shoe");
            if(n==4) System.out.println("Mayour Hockey Shoe");
            if(n==5) System.out.println("Malik Hockey Shoe");
            if(n==6) {stack.pop();page3(stack,sport,n);};}
          if(num==3){  
            if(n==1) System.out.println("Fenta Hockey LegPad");
            if(n==2) System.out.println("SNS Hockey LegPad");
            if(n==3) System.out.println("Grays Hockey LegPad");
            if(n==4) System.out.println("Mayour Hockey LegPad");
            if(n==5) System.out.println("Malik Hockey LegPad");
            if(n==6) {stack.pop();page3(stack,sport,n);};}
          if(num==4){
            if(n==1) System.out.println("Fenta Hockey Socks");
            if(n==2) System.out.println("SNS Hockey Socks");
            if(n==3) System.out.println("Grays Hockey Socks");
            if(n==4) System.out.println("Mayour Hockey Socks");
            if(n==5) System.out.println("Malik Hockey Socks");
            if(n==6) {stack.pop();page3(stack,sport,n);};}  
          }
          if(num==5){
            if(n==1) System.out.println("Fenta Hockey Stick Bags");
            if(n==2) System.out.println("SNS Hockey Stick Bags");
            if(n==3) System.out.println("Grays Hockey Stick Bags");
            if(n==4) System.out.println("Mayour Hockey Stick Bags");
            if(n==5) System.out.println("Malik Hockey Stick Bags");
            if(n==6) {stack.pop();page3(stack,sport,n);}; 
          }
    
        if(sport==2)
        {
           
            if(num==1){  
            if(n==1) System.out.println("Adidas Ball");
           if(n==2) System.out.println("Nike Ball");
           if(n==3) System.out.println("Puma Ball");
           if(n==4) System.out.println("Nivia Ball");
           if(n==5) System.out.println("Under Armour Ball");
           if(n==6) {stack.pop();page3(stack,sport,n);}}
          if(num==2){  
            if(n==1) System.out.println("Adidas Shoes");
           if(n==2) System.out.println("Nike Shoes");
           if(n==3) System.out.println("Puma Shoes");
           if(n==4) System.out.println("Nivia Shoes");
           if(n==5) System.out.println("Under Armour Shoes");
           if(n==6) {stack.pop();page3(stack,sport,n);}}
          if(num==3){  
            if(n==1) System.out.println("Adidas LegPad");
           if(n==2) System.out.println("Nike LegPad");
           if(n==3) System.out.println("Puma LegPad");
           if(n==4) System.out.println("Nivia LegPad");
           if(n==5) System.out.println("Under Armour LegPad");
           if(n==6) {stack.pop();page3(stack,sport,n);}}
          if(num==4){
            if(n==1) System.out.println("Adidas Socks");
           if(n==2) System.out.println("Nike Socks");
           if(n==3) System.out.println("Puma Socks");
           if(n==4) System.out.println("Nivia Socks");
           if(n==5) System.out.println("Under Armour Socks");
           if(n==6) {stack.pop();page3(stack,sport,n);}}  
          
          if(num==5){if(n==1) System.out.println("Adidas Bag");
           if(n==2) System.out.println("Nike Bag");
           if(n==3) System.out.println("Puma Bag");
           if(n==4) System.out.println("Nivia Bag");
           if(n==5) System.out.println("Under Armour Bag");
           if(n==6) {stack.pop();page3(stack,sport,n);} 
        }
        }
        System.out.println("0 to HomePage,1 to Previous Page");
        int decision=sc.nextInt();
        if(decision==0) {stack.clear();page1();}
        if(decision==1){stack.pop();page3(stack,sport,n);};
        }
    
}
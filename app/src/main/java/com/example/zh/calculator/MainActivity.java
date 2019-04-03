package com.example.zh.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String num1="";
    public String num2="";
    public String opreate="";
    public String temp="";
    public Boolean STATE=false;
    public int x=0;
    public double x_d=0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        final TextView textView=findViewById(R.id.display);
        Button b_ce=findViewById(R.id.ce);
        Button b_plus=findViewById(R.id.plus);
        Button b_sub=findViewById(R.id.jian);
        Button b_multi=findViewById(R.id.cheng);
        Button b_chu=findViewById(R.id.chu);
        Button b_equal=findViewById(R.id.equal);
        Button b_sqrt=findViewById(R.id.sqrt);
        Button b_c=findViewById(R.id.c);
        Button b_dot=findViewById(R.id.dot);
        Button b_0=findViewById(R.id.zero);
        Button b_1=findViewById(R.id.one);
        Button b_2=findViewById(R.id.two);
        Button b_3=findViewById(R.id.three);
        Button b_4=findViewById(R.id.four);
        Button b_5=findViewById(R.id.five);
        Button b_6=findViewById(R.id.six);
        Button b_7=findViewById(R.id.seven);
        Button b_8=findViewById(R.id.eight);
        Button b_9=findViewById(R.id.nine);

        //数字按钮点击事件
        b_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append("0");
                temp+="0";
            }
        });
        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("1");
                temp+="1";
            }
        });
        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("2");
                temp+="2";
            }
        });
        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("3");
                temp+="3";
            }
        });
        b_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("4");
                temp+="4";
            }
        });
        b_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("5");
                temp+="5";
            }
        });
        b_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("6");
                temp+="6";
            }
        });
        b_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("7");
                temp+="7";
            }
        });
        b_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("8");
                temp+="8";
            }
        });
        b_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("9");
                temp+="9";
            }
        });

        //按钮CE点击事件
        b_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                temp="";
                num1="";
                num2="";
                STATE=false;
                x=0;
                x_d=0;
            }
        });
        b_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=textView.getText().toString();
                str=str.substring(0,str.length()-1);
                textView.setText(str);
                temp=temp.substring(0,temp.length()-1);
            }
        });
        //按钮+点击事件
        //+操作时保存之前的操作数,传递一个+操作的信号
        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("+");
                if(num1.equals("")){
                    num1=temp;
                }else {
                    num2=temp;
                }
                if(!(num1.equals(""))&&!(num2.equals(""))){
                    switch (opreate){
                        case "+":{
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                int result=n1+n2;
                                temp=String.valueOf(result);
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1+n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                        case "-":{
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                int result=n1-n2;
                                temp=String.valueOf(result);
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1-n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                        case "×":{
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                int result=n1*n2;
                                if (STATE==true){
                                    if(x!=0){
                                        result+=x;
                                        temp=String.valueOf(result);
                                    }else {
                                        double result_d=result+x_d;
                                        temp=String.valueOf(result_d);
                                    }
                                }else {
                                    temp = String.valueOf(result);
                                }
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1*n2;
                                if (STATE==true){
                                    if(x!=0){
                                        result+=x;
                                        temp=String.valueOf(result);
                                    }else {
                                        result=result+x_d;
                                        temp=String.valueOf(result);
                                    }
                                }else {
                                    temp=String.valueOf(result);
                                }
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                        case "÷":{
                            if(num2.equals("0")){
                                temp="error";
                                break;
                            }
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                if(n1%n2==0){
                                    int result=n1/n2;
                                    temp=String.valueOf(result);
                                }
                                else {
                                    double result=(double)n1/n2;
                                    temp=String.valueOf(result);
                                }
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1/n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                    }
                }
                opreate="+";
                temp="";
            }
        });
        b_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("-");
                if(num1.equals("")){
                    num1=temp;
                }else {
                    num2=temp;
                }
                if(!(num1.equals(""))&&!(num2.equals(""))){
                    switch (opreate){
                        case "+":{
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                int result=n1+n2;
                                temp=String.valueOf(result);
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1+n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                        case "-":{
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                int result=n1-n2;
                                temp=String.valueOf(result);
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1-n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                        case "×":{
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                int result=n1*n2;
                                if (STATE==true){
                                    if(x!=0){
                                        result+=x;
                                        temp=String.valueOf(result);
                                    }else {
                                        double result_d=result+x_d;
                                        temp=String.valueOf(result_d);
                                    }
                                }else {
                                    temp = String.valueOf(result);
                                }
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1*n2;
                                if (STATE==true){
                                    if(x!=0){
                                        result+=x;
                                        temp=String.valueOf(result);
                                    }else {
                                        result=result+x_d;
                                        temp=String.valueOf(result);
                                    }
                                }else {
                                    temp=String.valueOf(result);
                                }
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                        case "÷":{
                            if(num2.equals("0")){
                                temp="error";
                                break;
                            }
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                if(n1%n2==0){
                                    int result=n1/n2;
                                    temp=String.valueOf(result);
                                }
                                else {
                                    double result=(double)n1/n2;
                                    temp=String.valueOf(result);
                                }
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1/n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                    }
                }
                opreate="-";
                temp="";
            }
        });
        b_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("×");
                if(num1.equals("")){
                    num1=temp;
                }else {
                    num2=temp;
                }
                if(!(num1.equals(""))&&!(num2.equals(""))){
                    switch (opreate){
                        case "+":{
                            STATE=true;
                            if(num1.contains(".")){
                                x_d=Double.parseDouble(num1);
                            }
                            else {
                                x=Integer.parseInt(num1);
                            }
                            num1=num2;
                            break;
                        }
                        case "-":{
                            STATE=true;
                            if(num1.contains(".")){
                                x_d=Double.parseDouble(num1);
                            }
                            else {
                                x=Integer.parseInt(num1);
                            }
                            num1=num2;
                            break;
                        }
                        case "×":{
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                int result=n1*n2;
                                temp=String.valueOf(result);
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1*n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                        case "÷":{
                            if(num2.equals("0")){
                                temp="error";
                                break;
                            }
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                if(n1%n2==0){
                                    int result=n1/n2;
                                    temp=String.valueOf(result);
                                }
                                else {
                                    double result=(double)n1/n2;
                                    temp=String.valueOf(result);
                                }
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1/n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                    }
                }
                opreate="×";
                temp="";
            }
        });
        b_chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("÷");
                if(num1.equals("")){
                    num1=temp;
                }else {
                    num2=temp;
                }
                if(!(num1.equals(""))&&!(num2.equals(""))){
                    switch (opreate){
                        case "+":{
                            STATE=true;
                            if(num1.contains(".")){
                                x_d=Double.parseDouble(num1);
                            }
                            else {
                                x=Integer.parseInt(num1);
                            }
                            num1=num2;
                            break;
                        }
                        case "-":{
                            STATE=true;
                            if(num1.contains(".")){
                                x_d=Double.parseDouble(num1);
                            }
                            else {
                                x=Integer.parseInt(num1);
                            }
                            num1=num2;
                            break;
                        }
                        case "×":{
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                int result=n1*n2;
                                temp=String.valueOf(result);
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1*n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                        case "÷":{
                            if(num2.equals("0")){
                                temp="error";
                                break;
                            }
                            if(!(num1.contains("."))&&!(num2.contains("."))){
                                int n1=Integer.parseInt(num1);
                                int n2=Integer.parseInt(num2);
                                if(n1%n2==0){
                                    int result=n1/n2;
                                    temp=String.valueOf(result);
                                }
                                else {
                                    double result=(double) n1/n2;
                                    temp=String.valueOf(result);
                                }
                            }
                            else{
                                double n1=Double.parseDouble(num1);
                                double n2=Double.parseDouble(num2);
                                double result=n1/n2;
                                temp=String.valueOf(result);
                            }
                            num1=temp;
                            num2="";
                            break;
                        }
                    }
                }
                opreate="÷";
                temp="";
            }
        });
        b_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append("√");
                opreate="√";
                num1=temp;
                temp="";
            }
        });

        //按钮=点击事件
        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("=");
                num2=temp;
                temp="";
                switch (opreate){
                    case "+": {
                        if(!(num1.contains("."))&&!(num2.contains("."))){
                            int n1=Integer.parseInt(num1);
                            int n2=Integer.parseInt(num2);
                            int result=n1+n2;
                            temp=String.valueOf(result);
                        }
                        else{
                            double n1=Double.parseDouble(num1);
                            double n2=Double.parseDouble(num2);
                            double result=n1+n2;
                            temp=String.valueOf(result);
                        }
                        break;
                    }
                    case "-": {
                        if(!(num1.contains("."))&&!(num2.contains("."))){
                            int n1=Integer.parseInt(num1);
                            int n2=Integer.parseInt(num2);
                            int result=n1-n2;
                            temp=String.valueOf(result);
                        }
                        else{
                            double n1=Double.parseDouble(num1);
                            double n2=Double.parseDouble(num2);
                            double result=n1-n2;
                            temp=String.valueOf(result);
                        }
                        break;
                    }
                    case "×": {
                        if(!(num1.contains("."))&&!(num2.contains("."))){
                            int n1=Integer.parseInt(num1);
                            int n2=Integer.parseInt(num2);
                            int result=n1*n2;
                            if (STATE==true){
                                if(x!=0){
                                    result+=x;
                                    temp=String.valueOf(result);
                                }else {
                                    double result_d=result+x_d;
                                    temp=String.valueOf(result_d);
                                }
                            }else {
                                temp=String.valueOf(result);
                            }

                        }
                        else{
                            double n1=Double.parseDouble(num1);
                            double n2=Double.parseDouble(num2);
                            double result=n1*n2;
                            temp=String.valueOf(result);
                        }
                        break;
                    }
                    case "÷": {
                        if(num2.equals("0")){
                            temp="error";
                            break;
                        }
                        if(!(num1.contains("."))&&!(num2.contains("."))){
                            int n1=Integer.parseInt(num1);
                            int n2=Integer.parseInt(num2);
                            if(n1%n2==0){
                                int result=n1/n2;
                                temp=String.valueOf(result);
                            }
                            else {
                                double result_b=(double) n1/n2;
                                temp=String.valueOf(result_b);
                            }
                        }
                        else{
                            double n1=Double.parseDouble(num1);
                            double n2=Double.parseDouble(num2);
                            double result=n1/n2;
                            temp=String.valueOf(result);
                        }
                        break;
                    }
                    case "√":{
                        if(!(num1.contains("."))){
                            double n1=Double.parseDouble(num1);
                            if(n1<0){
                                temp="error";
                                break;
                            }
                            else{
                                double result = Math.sqrt(n1);
                                temp=String.valueOf(result);
                            }
                        }
                        else{
                            int n1 =Integer.parseInt(num1);
                            if(n1<0){
                                temp="error";
                                break;
                            }
                            else{
                                double result=Math.sqrt(n1);
                                temp=String.valueOf(result);
                                break;
                            }
                        }
                    }
                }

                textView.append(temp);
                num1="";
                num2="";
                STATE=false;
                x=0;
                x_d=0;
            }
        });

        //按钮.点击事件
        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append(".");
                temp+=".";
            }
        });
    }
}

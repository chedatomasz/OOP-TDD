package onp;

import java.util.EmptyStackException;
import java.util.Stack;

public class ONP {
    public int policz(String polecenie) throws PustyStos, DzieleniePrzezZero, ZaMaloOperatorow, BlednyZnak{
        Stack<Integer> buffer = new Stack<>();
        for(int i = 0; i < polecenie.length(); i++){
            char current = polecenie.charAt(i);
            if(Character.digit(current, 10) >=0 ){
                buffer.push(Character.digit(current, 10));
            }
            else if(current == '*' || current == '+' || current == '-' || current == '/'){
                int first;
                int second;
                try{
                    first = buffer.pop();
                    second = buffer.pop();
                }
                catch(EmptyStackException e){
                    throw new PustyStos(e);
                }
                if(current == '+'){
                    buffer.push(first+second);
                }
                else if(current == '-'){
                    buffer.push(second - first);
                }
                else if(current == '*'){
                    buffer.push( second*first);
                }
                else{
                    if(first == 0){
                        throw new DzieleniePrzezZero();
                    }
                    buffer.push(second / first);
                }
            }
            else{
                throw new BlednyZnak();
            }
        }
        if(buffer.empty()){
            throw new PustyStos();
        }
        if(buffer.size()>1){
            throw new ZaMaloOperatorow();
        }
        return buffer.pop();
    }
}


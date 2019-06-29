package bst;

public class BST <T extends Comparable<T>> {

    private BSTNode<T> node;

    public void add(T contents){
        node = node.recursiveAdd(contents);
    }

    public int size(){
        return node.size();
    }

    public Boolean exists(T content){
        return node.exists(content);
    }

    public void remove(T content){
        node = node.remove(content);
    }

    public BST(){
        this.node = new emptyBSTNode<>();
    }
}

abstract class BSTNode <T extends Comparable<T>>{
    T contents;
    BSTNode<T> left;
    BSTNode<T> right;

    abstract public BSTNode<T> recursiveAdd(T content);

    abstract public Boolean exists(T content);

    abstract public int size();

    abstract BSTNode<T> delete();

    abstract Boolean isReal();

    abstract BSTNode<T> getRightmost();

    public BSTNode<T> remove(T content){
        if(this.contents.compareTo(content) < 0){
            this.left = this.left.remove(content);
            return this;
        }
        else if (this.contents.compareTo(content) > 0){
            this.right = this.right.remove(content);
            return this;
        }
        else if(this.contents.equals(content)){
            return this.delete();
        }
        return this;
    }

}

class fullBST <T extends Comparable<T>> extends BSTNode<T>{

    fullBST(){
        this.left = new emptyBSTNode<>();
        this.right = new emptyBSTNode<>();
    }

    @Override
    public BSTNode<T> recursiveAdd(T content){
        if(this.contents.compareTo(content) < 0){
            left = left.recursiveAdd(content);
        }
        else if(this.contents.compareTo(content) > 0){
            right = right.recursiveAdd(content);
        }
        return this;
    }

    @Override
    public Boolean exists(T content){
        return this.contents.equals(content) || left.exists(content) || right.exists(content);
    }

    @Override
    public int size(){
        return 1 + left.size() + right.size();
    }

    @Override
    public BSTNode<T> delete(){

        //No children
        if(!left.isReal() && !right.isReal()){
            return new emptyBSTNode<>();
        }
        //No left child
        if(!left.isReal()){
            return right;
        }
        //No right child
        if(!right.isReal()){
            return left;
        }
        //Both children
        BSTNode<T> inOrderSuccessor = this.left.getRightmost();
        this.contents = inOrderSuccessor.contents;
        inOrderSuccessor.delete();
        return this;
    }

    @Override
    public Boolean isReal(){
        return true;
    }

    @Override
    BSTNode<T> getRightmost(){
        BSTNode<T> candidate = right.getRightmost();
        if(candidate != null){
            return candidate;
        }
        return this;
    }
}

class emptyBSTNode<T extends Comparable<T>> extends BSTNode<T>{

    @Override
    public BSTNode<T> recursiveAdd(T content){
        BSTNode<T> result = new fullBST<>();
        result.contents = content;
        return result;
    }

    @Override
    public Boolean exists(T content){
        return false;
    }

    @Override
    public int size(){
        return 0;
    }

    @Override
    public BSTNode<T> remove(T content){
        return this;
    }

    @Override
    public BSTNode<T> delete(){
        return null;
    }

    @Override
    public Boolean isReal(){
        return false;
    }

    @Override
    BSTNode<T> getRightmost(){
        return null;
    }
}

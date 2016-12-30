//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJDepthFirst<R,A> implements GJVisitor<R,A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
  HashMap<String,String> parentstore = new HashMap<String,String>();
  HashMap<String,String> varstore = new HashMap<String,String>();
  HashMap<String,String> funcstore = new HashMap<String,String>();
  HashMap<String,ArrayList> parastore = new HashMap<String,ArrayList>();
  String classname="";
  String funcname="";
  String pclassname="";
  String rettype="";
  ArrayList al;
  int purposeflag=0;
   public R visit(NodeList n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n, A argu) {
      if ( n.present() )
         return n.node.accept(this,argu);
      else
         return null;
   }

   public R visit(NodeSequence n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n, A argu) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> MainClass()
    * f1 -> ( TypeDeclaration() )*
    * f2 -> <EOF>
    */
   public R visit(Goal n, A argu) {
      Integer temp=Integer.parseInt((String)argu);
      purposeflag=temp.intValue();
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> "public"
    * f4 -> "static"
    * f5 -> "void"
    * f6 -> "main"
    * f7 -> "("
    * f8 -> "String"
    * f9 -> "["
    * f10 -> "]"
    * f11 -> Identifier()
    * f12 -> ")"
    * f13 -> "{"
    * f14 -> PrintStatement()
    * f15 -> "}"
    * f16 -> "}"
    */
   public R visit(MainClass n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      n.f12.accept(this, argu);
      n.f13.accept(this, argu);
      n.f14.accept(this, argu);
      n.f15.accept(this, argu);
      n.f16.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> ClassDeclaration()
    *       | ClassExtendsDeclaration()
    */
   public R visit(TypeDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> ( VarDeclaration() )*
    * f4 -> ( MethodDeclaration() )*
    * f5 -> "}"
    */
   public R visit(ClassDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      classname=n.f1.f0.toString();
      pclassname="NoParentClassDefined";
      if(purposeflag==0)addparentstore();
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      pclassname="";
      classname="";
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "extends"
    * f3 -> Identifier()
    * f4 -> "{"
    * f5 -> ( VarDeclaration() )*
    * f6 -> ( MethodDeclaration() )*
    * f7 -> "}"
    */
   public R visit(ClassExtendsDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      classname=n.f1.f0.toString();
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      pclassname=n.f3.f0.toString();
      if(purposeflag==0)addparentstore();
      funcname="";
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      pclassname="";
      classname="";
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public R visit(VarDeclaration n, A argu) {
      R _ret=null;
      String dtype=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String var = n.f1.f0.toString();
      n.f2.accept(this, argu);
      if(purposeflag==0)addvarstore(var,dtype);
      return _ret;
   }

   /**
    * f0 -> "public"
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( FormalParameterList() )?
    * f5 -> ")"
    * f6 -> "{"
    * f7 -> ( VarDeclaration() )*
    * f8 -> ( Statement() )*
    * f9 -> "return"
    * f10 -> Expression()
    * f11 -> ";"
    * f12 -> "}"
    */
   public R visit(MethodDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String rettype1=(String)n.f1.accept(this, argu);
      rettype=rettype1;
      n.f2.accept(this, argu);
      funcname=n.f2.f0.toString();
      if(purposeflag==0)addfuncstore();
      al = new ArrayList();
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      if(purposeflag==0)addparastore();
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      String dtype=(String)n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      n.f12.accept(this, argu);
      funcname="";
      rettype="";
      if(dtype!=null && dtype.equals(rettype1))return _ret;
      else if(classexists(dtype)==1){
         if(checkifparent(rettype1,dtype)==1)return _ret;
         else reporttypeerror();
      }
      else reporttypeerror();
      return _ret;
   }

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public R visit(FormalParameterList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public R visit(FormalParameter n, A argu) {
      R _ret=null;
      String dtype=(String)n.f0.accept(this, argu);
      al.add(dtype);
      n.f1.accept(this, argu);
      String var=n.f1.f0.toString();
      if(purposeflag==0)addvarstore(var,dtype);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public R visit(FormalParameterRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> ArrayType()
    *       | BooleanType()
    *       | IntegerType()
    *       | Identifier()
    */
   public R visit(Type n, A argu) {
      R _ret=null;
      String dtype=(String)n.f0.accept(this, argu);
      if(dtype.equals("int") || dtype.equals("int []") || dtype.equals("boolean"))return (R)dtype;
      if(purposeflag==1){
         if(classexists(dtype)==1)return (R)dtype;
         else reporttypeerror();
      }
      return (R)dtype;
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public R visit(ArrayType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return (R)"int []";
   }

   /**
    * f0 -> "boolean"
    */
   public R visit(BooleanType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)"boolean";
   }

   /**
    * f0 -> "int"
    */
   public R visit(IntegerType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)"int";
   }

   /**
    * f0 -> Block()
    *       | AssignmentStatement()
    *       | ArrayAssignmentStatement()
    *       | IfStatement()
    *       | WhileStatement()
    *       | PrintStatement()
    */
   public R visit(Statement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public R visit(Block n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public R visit(AssignmentStatement n, A argu) {
      R _ret=null;
      String lhs=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String rhs=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      String dtype=getvartype(classname, funcname, lhs);
      if(dtype.equals(rhs))return _ret;
      else if(classexists(rhs)==1 && classexists(dtype)==1 && checkifparent(dtype,rhs)==1)return _ret;
      else reporttypeerror();
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "["
    * f2 -> Expression()
    * f3 -> "]"
    * f4 -> "="
    * f5 -> Expression()
    * f6 -> ";"
    */
   public R visit(ArrayAssignmentStatement n, A argu) {
      R _ret=null;
      String var=(String)n.f0.accept(this, argu);
      String dtype1=getvartype(classname, funcname, var);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      String dtype3=(String)n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      if(dtype1.equals("int []") && dtype2.equals("int") && dtype3.equals("int"))return _ret;
      else reporttypeerror();
      return _ret;
   }

   /**
    * f0 -> IfthenElseStatement()
    *       | IfthenStatement()
    */
   public R visit(IfStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(IfthenStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      if(dtype!=null && dtype.equals("boolean"))return _ret;
      else reporttypeerror();
      return _ret;
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> "else"
    * f6 -> Statement()
    */
   public R visit(IfthenElseStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      if(dtype!=null && dtype.equals("boolean"))return _ret;
      else reporttypeerror();
      return _ret;
   }

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(WhileStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      if(dtype!=null && dtype.equals("boolean"))return _ret;
      else reporttypeerror();
      return _ret;
   }

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> ";"
    */
   public R visit(PrintStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      if(dtype!=null && dtype.equals("int"))return _ret;
      else reporttypeerror();
      return _ret;
   }

   /**
    * f0 -> OrExpression()
    *       | AndExpression()
    *       | CompareExpression()
    *       | neqExpression()
    *       | PlusExpression()
    *       | MinusExpression()
    *       | TimesExpression()
    *       | DivExpression()
    *       | ArrayLookup()
    *       | ArrayLength()
    *       | MessageSend()
    *       | PrimaryExpression()
    */
   public R visit(Expression n, A argu) {
      R _ret=null;
      String dtype=(String)n.f0.accept(this, argu);
      return (R)dtype;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "&&"
    * f2 -> PrimaryExpression()
    */
   public R visit(AndExpression n, A argu) {
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      if(dtype1==dtype2 && dtype1.equals("boolean")) return (R)"boolean";
      else reporttypeerror();
      return (R)"boolean";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "||"
    * f2 -> PrimaryExpression()
    */
   public R visit(OrExpression n, A argu) {
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      if(dtype1==dtype2 && dtype1.equals("boolean")) return (R)"boolean";
      else reporttypeerror();
      return (R)"boolean";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "<="
    * f2 -> PrimaryExpression()
    */
   public R visit(CompareExpression n, A argu) {
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      if(dtype1==dtype2 && dtype1.equals("int")) return (R)"boolean";
      else reporttypeerror();
      return (R)"boolean";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "!="
    * f2 -> PrimaryExpression()
    */
   public R visit(neqExpression n, A argu) {
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      if(dtype1==dtype2 && (dtype1.equals("boolean") || dtype1.equals("int"))) return (R)"boolean";
      else reporttypeerror();
      return (R)"boolean";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "+"
    * f2 -> PrimaryExpression()
    */
   public R visit(PlusExpression n, A argu) {
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      if(dtype1==dtype2 && dtype1.equals("int")) return (R)"int";
      else reporttypeerror();
      return (R)"int";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "-"
    * f2 -> PrimaryExpression()
    */
   public R visit(MinusExpression n, A argu) {
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      if(dtype1==dtype2 && dtype1.equals("int")) return (R)"int";
      else reporttypeerror();
      return (R)"int";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "*"
    * f2 -> PrimaryExpression()
    */
   public R visit(TimesExpression n, A argu) {
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      if(dtype1==dtype2 && dtype1.equals("int")) return (R)"int";
      else reporttypeerror();
      return (R)"int";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "/"
    * f2 -> PrimaryExpression()
    */
   public R visit(DivExpression n, A argu) {
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      if(dtype1==dtype2 && dtype1.equals("int")) return (R)"int";
      else reporttypeerror();
      return (R)"int";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "["
    * f2 -> PrimaryExpression()
    * f3 -> "]"
    */
   public R visit(ArrayLookup n, A argu) {
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      if(dtype1.equals("int []") && dtype2.equals("int")) return (R)"int";
      else reporttypeerror();
      return (R)"int";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> "length"
    */
   public R visit(ArrayLength n, A argu) {
      R _ret=null;
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      if(dtype1.equals("int []")) return (R)"int";
      else reporttypeerror();
      return (R)"int";
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( ExpressionList() )?
    * f5 -> ")"
    */
   public R visit(MessageSend n, A argu) {
      R _ret=null;
      String dtype1=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String dtype2=(String)n.f2.accept(this, argu);
      String var=n.f2.f0.toString();
      ArrayList al1= new ArrayList();
      al1=getparalist(dtype1, dtype2);
      String rettype1=getrettype(dtype1,dtype2);
      n.f3.accept(this, argu);
      n.f4.accept(this, (A)al1);
      n.f5.accept(this, argu);
      if(al1!=null && al1.size()==0)return (R)rettype1;
      else reporttypeerror();
      return (R)"int";
   }

   /**
    * f0 -> Expression()
    * f1 -> ( ExpressionRest() )*
    */
   public R visit(ExpressionList n, A argu) {
      ArrayList al1= (ArrayList)argu;
      R _ret=null;
      String dtype=(String)n.f0.accept(this, argu);
      if(removeal(dtype,dtype,al1)==0)reporttypeerror();
      n.f1.accept(this, argu);
      return (R)"int";
   }

   /**
    * f0 -> ","
    * f1 -> Expression()
    */
   public R visit(ExpressionRest n, A argu) {
      ArrayList al1= (ArrayList)argu;
      R _ret=null;
      n.f0.accept(this, argu);
      String dtype=(String)n.f1.accept(this, argu);
      if(removeal(dtype,dtype,al1)==0) reporttypeerror();
      return (R)"int";
   }

   /**
    * f0 -> IntegerLiteral()
    *       | TrueLiteral()
    *       | FalseLiteral()
    *       | Identifier()
    *       | ThisExpression()
    *       | ArrayAllocationExpression()
    *       | AllocationExpression()
    *       | NotExpression()
    *       | BracketExpression()
    */
   public R visit(PrimaryExpression n, A argu) {
      R _ret=null;
      String dtype=(String)n.f0.accept(this, argu);
      if(dtype.equals("int") || dtype.equals("int []") || dtype.equals("boolean") || classexists(dtype)==1)return (R)dtype;
      else return (R)getvartype(classname,funcname,dtype);
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)"int";
   }

   /**
    * f0 -> "true"
    */
   public R visit(TrueLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)"boolean";
   }

   /**
    * f0 -> "false"
    */
   public R visit(FalseLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)"boolean";
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String dtype=(String)n.f0.toString();
      return (R)dtype;
   }

   /**
    * f0 -> "this"
    */
   public R visit(ThisExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)classname;
   }

   /**
    * f0 -> "new"
    * f1 -> "int"
    * f2 -> "["
    * f3 -> Expression()
    * f4 -> "]"
    */
   public R visit(ArrayAllocationExpression n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      String dtype=(String)n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      if(dtype.equals("int"))return (R)"int []";
      else reporttypeerror();
      return (R)"int []";
   }

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public R visit(AllocationExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String dtype=(String)n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      if(purposeflag==1){
         if(classexists(dtype)==1)return (R)dtype;
         else reporttypeerror();
      }
      return (R)dtype;
   }

   /**
    * f0 -> "!"
    * f1 -> Expression()
    */
   public R visit(NotExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String dtype=(String)n.f1.accept(this, argu);
      if(dtype.equals("boolean"))return (R)"boolean";
      else reporttypeerror();
      return (R)"boolean";
   }

   /**
    * f0 -> "("
    * f1 -> Expression()
    * f2 -> ")"
    */
   public R visit(BracketExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String dtype=(String)n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return (R)dtype;
   }

   /**
    * f0 -> Identifier()
    * f1 -> ( IdentifierRest() )*
    */
   public R visit(IdentifierList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return (R)"int";
   }

   /**
    * f0 -> ","
    * f1 -> Identifier()
    */
   public R visit(IdentifierRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return (R)"int";
   }

   public void reporttypeerror(){
      if(purposeflag==1){
         System.out.println("Type error");
         System.exit(0);
      }
      return ;
   }
   public void reporttypeerror1(){
      System.out.println("Type error");
      System.exit(0);
      return ;
   }

   public void addparentstore(){
      if(parentstore.get(classname)==null)parentstore.put(classname,pclassname);
      else reporttypeerror1();
      return ;
   }

   public void addfuncstore(){
      if(funcstore.get(classname+"."+funcname)==null)funcstore.put(classname+"."+funcname,rettype);
      else reporttypeerror1();
      return ;
   }

   public void addparastore(){
      if(parastore.get(classname+"."+funcname)==null)parastore.put(classname+"."+funcname,al);
      else reporttypeerror1();
      return ;
   }

   public void addvarstore(String var, String dtype){
      if(varstore.get(classname+"."+funcname+"."+var)==null)varstore.put(classname+"."+funcname+"."+var ,dtype);
      else reporttypeerror1();
      return ;
   }

   public String getvartype(String cname, String fname, String var){
      String withinfunc=varstore.get(cname+"."+fname+"."+var);
      if(withinfunc!=null)return withinfunc;
      String withinclass=varstore.get(cname+"."+"."+var);
      if(withinclass!=null)return withinclass;
      String parent=parentstore.get(cname);
      if(parent==null || parent.equals("NoParentClassDefined") || parent.equals(classname))reporttypeerror();
      else return getvartype(parent,"",var);
      return "int";
   }

   public ArrayList getparalist(String cname, String fname){
      ArrayList withinclass = new ArrayList();
      withinclass = parastore.get(cname+"."+fname);
      if(withinclass!=null)return new ArrayList(withinclass);
      String parent=parentstore.get(cname);
      if(parent==null || parent.equals("NoParentClassDefined") || parent.equals(classname))reporttypeerror();
      else return getparalist(parent,fname);
      return al;
   }

   public String getrettype(String cname, String fname){
      String withinfunc=funcstore.get(cname+"."+fname);
      if(withinfunc!=null)return withinfunc;
      String parent=parentstore.get(cname);
      if(parent==null || parent.equals("NoParentClassDefined") || parent.equals(classname))reporttypeerror();
      else return getrettype(parent,fname);
      return "int";
   }

   public int classexists(String cname){
      String parent=parentstore.get(cname);
      if(parent==null)return 0;
      return 1;
   }

   public int removeal(String cname1, String cname2, ArrayList al1){
      String parent=parentstore.get(cname2);
      if(purposeflag==1 && al1!=null && al1.size()!=0 && al1.get(0).equals(cname2)){al1.remove(0);return 1;}
      else if(parent==null || parent.equals("NoParentClassDefined") || parent.equals(cname1))return 0;
      else return removeal(cname1,parent,al1);
   }
         
   public int checkifparent(String cname, String child){
      String parent=parentstore.get(child);
      if(parent==null || parent.equals("NoParentClassDefined"))return 0;
      else if(parent.equals(cname))return 1;
      else return checkifparent(cname,parent);
   }
}

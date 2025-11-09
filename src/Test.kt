//การสร้างinterface
//เป็นการกำหนดแค่โครงสร้างการทำงาน
interface User{
    val id: String
    val password: String
    fun generate()
}

//primary Constructor จะอยู่ข้างๆชื่อคลาส หรือเรียกว่าclass Header
//class Employee(var name:String,var salary:Int)
abstract class Employee{
    private var name: String
    fun getName():String = name
    private var salary:Int
    //มีแค่คลาสลูกเท่่านั้นที่เรียกใช้ได้ pprotected
    //การoverride ต้องประกาศว่าopen
    protected open var leader:String = "สมชาย"
    //abstract คือกำหนดไว้ให้คนอื่นมาใช้ต่อและกำหนดค่าภายในมันด้วยตัวเอง
    abstract var role: String
    abstract fun report()
    //การใช้object โดยไม่ต้องสร้างตัวแปรสามารถเรียกใช้โดยใชช้ชื่อคลาสได้เลยเ
    //หรือเรียกอีกอย่างว่าstatic
    companion object{
        var count = 0

    }
    //second constructor
    constructor(emp_name:String,emp_salary:Int){
        this.name = emp_name.ifEmpty{"Unknown"}
        this.salary = if(emp_salary < 55000) 51000 else emp_salary
        count++
    }
////init block คือการกำหนดขอบเขตการทำงานของprimary constructor
//    init{
//        if(name.isEmpty()){
//            name="Unknown"
//        }
//        if(salary < 55000){
//            salary= 51000
//        }
//    }
//

//    var name:String = "Phoosith"
//    var salary:Int = 50_000

        //วิธีใช้backing field //field คือตัวแทนของข้อมูลproperty
//        get() = field
//        set(value){
//            if(value >0){
//                field = value
//            }
//
//        }
//    private var gender:String?=null //ไม่สามารถเปลี่ยนค่าได้จากภายนอกคลาสนี้

    //method
    open fun display(){
        println("-----Employee Data-----")
        println("Name : $name")
        println("Salary : $salary บาท")
    }

}

class Sale:Employee{
    private  var area:String

    //วิธีการoverride //overrideคือการชื่อเหมืือนกันแต่การทำงานหรือค่าต่างกัน
    override var leader:String = "สมปอง"
    override var role:String = "จำหน่าย"
    //super คือการเรียกใช้เมื่อต้องการความสามารถของคลาสแม่
    constructor(sale_name:String,sale_salary:Int,area:String):super(sale_name,sale_salary){
        this.area = area
    }

    override fun display() {
        super.display()
        println("Area = $area")
        println("Leader = ${leader}")
        println("Role : $role")
        report()
    }

    override fun report(){
        println("Profit 1 Million")
    }

}

class IT:Employee,User{
    private var exp: Int
    override var role:String = "Developer Software"

    //interface
    override val id="UID_${getName()}"
    override val password="UPW_${getName()}"

    override fun generate(){
        println("ID: $id")
        println("Password: $password")
    }
    //innterface

    constructor(it_name:String,it_salary:Int,it_exp:Int):super(it_name,it_salary){
        this.exp = it_exp
    }

    override fun display(){
        super.display()
        println("Exp : $exp")
        println("Leader : ${leader}")
        println("Role : $role")
        report()
    }

    override fun report(){
        println("Server Fail")
    }
}
//interface จะเป็นabstract ทั้งหมด ไม่ต้องกำหนดabstract ไว้ข้างหน้า


//OOP
fun main(){

    //คลาสเริ่มต้นในภาษาkotlin จะเป็นfinal class ถ้าอยากสืบทอดตั้งกำหนดเป็นpublic
    //การสร้างobject val obj_name = class_name()
    println("Hello OOP")

//    val emp1 = Employee()
//    println(emp1.name) //วิธีการเข้าถึง
//    println(emp1.salary)
    //วิธีการใช้get set
//    emp1.salary = 55000
//    println(emp1.salary)

//    //method
//    val emp2 = Employee()
//    emp2.name = "B"
//    emp2.display()
//    //การใช้Apply ทำให้ไม่ต้องมาเขียนที่ละตัว
//    emp2.apply{
//        name= "C"
//        salary=55000
//        display()
//    }

    //primary constructor
//    val emp1 = Employee("Phoosith",55000)
//    emp1.display()
//    val emp2 = Employee("",50000)
//    emp2.display()

    //การใช้companion object
    println("Total Employee ${Employee.count}")

    val sale1 = Sale("SalerName",50000,"Empire Tower")
    sale1.display()
    val it1 = IT("ITName",60000,1)
    it1.display()
    it1.generate()
}


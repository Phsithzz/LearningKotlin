//function แบบปกติ
fun sayHi():Unit{ //unit คือไม่return
    println("Hello Kotlin sayHi 1")
}
//function แบบมีพารามิเตอร์
fun sayName(name:String){
    println("Hello $name")
}
//function แบบกำหนดค่าเริ่มต้น
fun showData(name:String,age:Int = 20){
    println("name: $name age:$age")
}
//function return
fun calculate(x:Int,y:Int):Int{
    return x+y
}
//vararg คือการทำให้ตอนเรียกใช้ใส่พารามิเตอร์ได้กีตัวก็ได้้
//การสร้างพารามิเตออร์ที่ทำงานในฟังก์ชันแบบไม่จำกัดจำนวน
fun calculateNum(vararg numbers:Int):Int{
    var total = 0
    for(item in numbers){
        total += item
    }
    return total
}
//function overloading คือการที่function มีชื่อเหมือนกันแต่จำนวนพารามิเตอร์และประเภทข้อมูลที่รับแตกต่างกัน
fun sayHi(name:String){
    println("Hello sayHi 2")
}
//lambda ใช้it แทนได้ตรงa:Int
val sum:(Int,Int)->Int={a:Int,b:Int->a+b}




fun main(){
    sayHi()
    sayHi("Test")
    sayName("Phoosith")
    showData("A")
    println("Hello Kotlin World")
    println(  calculateNum(10,20,30))
    //Phase1
    //comment
    //1.ตัวแปร
    var _name:String = "Phoo"
    var age:Int = 20
    var grade:Float = 4.00F //ต้องมีF
    var status:Boolean = true
    var gender:Char = 'A'
    println("Student Name = $_name") // สามารถเขียนแบบนี้ได้
    println(gender +" : "+_name +" : "+ age +" : " +grade+" : "+status)

    //2.ค่าคงที่
    val email = "abcd@gmail.com"

    //3.type interface เป็นการไม่กำหนดชนิดข้อมูล
    var test = true //boolean

    //4.type casting คือการแปลงข้อมูล
    var testTwo = 25.toDouble()
    println(testTwo)

    //5. a++ ++a a-- --a
    //6. x+=y x =x+y เครื่องหมาย%คือการเอาแค่เศษหรือการMod
    //7. == != <= >=

    //8.ตัวดำเนินกการกำหนดช่วงข้อมูล
    var a = 1..5 //พิมแค่..
    //var a = 1..5 step 2 ก๋คือเพิ่มที่ละ2
    //var a = 1until5  ก๋คือ1 ถึง 4 ใช้step ได่้เหมือนกัน
    //var a = 5downTo1 //5 4 3 2 1 //ใช้step ได้
    println(a)
    println(4 in a)
    println(3 !in a)
    println(a.first)
    println(a.last)

    //9.if statement
    var score:Int = 70
    if(score >= 80){
        println("Pass")
    }
    else if(score >= 70){
        println("Grade B")
    }
    else println("Fail")
    // ตัวดำเนินการทางตรรกศาสตร์ && || !

    //10.when คล้ายๆกับswitch case
    var number = 1
    when(number){
        1->println("Open")
        2->println("Close")
        else->println("Invalid Data")
    }

    //11.while loop
    var count = 1
    while(count <4){
        println("Hello While loop")
        count++
    }

    //12.for loop จะคล้ายๆ python
    for(i in 1..10 step 2){
        print(i)
    }
    println() // พิมแบบนี้ก็ได้
    for(j in 1 until 10){
        print(j)
    }
    println()

    //13.repeat เป็นการซ้ำให้ครบตามจำนวนครั้งที่กำหนด
    repeat(times=5){
        print("Aa")
    }
    println()

    //14.pair เป็นการเก่็บชุดข้อมูลที่ประกอบด้วยสมาชิก2ตัว เก็บข้อมูลแบบคู่
    //เก็บได้แค่2ตัว ไม่จำเป็นต้องชนิดข้อมูลชนิดเดียวกัน
    var data = Pair("A",20)
    println(data)
    //วิธีเข้าถึงข้อมูล
    println(data.first)
    println(data.second)
    //สามารถเขียนอีกแบบได้
    var (name,age2) = Pair("A",20)
    println("name: $name age:$age2")

    //15.triple ก็เก็บได้3ตัว
    var date = Triple(15,7,2005)
    println(date)
    //วิธีเข้าถึงข้อมูล
    println(date.third)

    //16.การเข้าถึงstring
    var firstname ="Phoosith"
    var lastname="Test"
    println(firstname[0])

    //การเขียนหลายบรรทัด
    var profile = """
        ชื่อ: $firstname
        นามสกุล:$lastname
    """.trimIndent() //trimช่วยให้ชิดซ้าย
    print(profile)
    println()
    //function เกี่ยวกับstring
    //length or count()
    //equals() indexOf(string)ลำดับตัวอักษรที่เจอครั้งแรก
    //lastIndex(string)
    //replaceFirst(old,string) = แทนที่string ที่พบครั้งแรกด้วยstring ใหม่
    //replce(old,string) = แทนที่string ที่พบทั้งหมดด้วยstring ใหม่
    //trim คือการตัดช่องว่างซ้ายขวา

    //Phase2

    //1.การรับค่าจากคีย์บอร์ด //readLine
//    print("Enter Your Name :")
//    var n = readLine()
//    println(n)

    //2.Array
    //array of คือไม่จำกัดชนิดข้อมูลที่เก็บ
    val dataArray = arrayOf("A",2,3,4)
    //วิธีการแสดงผล
    println(dataArray[0])
    for(item in dataArray){
        println(item)
    }

    //การสร้างarray แบบคลาส ต้องกำหนดขนาดก็คือเป็นการเก็บเฉพาะประเภทข้อมูลที่เหมือนกัน
    val arr1 = IntArray(3)
    arr1[0] = 1
    arr1[1] = 2
    arr1[2] = 3
    println(arr1[1])

    //การสร้างarray แบบฟังก์ชัน ชนิดข้อมูลข้างในต้องเหมือนกัน
    val arr2 = intArrayOf(100,200,300) //จองพื้นที่ไว้3ช่อง
    println(arr2[2])

    //ฟังก์ชันในการจัดการArray
    val arr3 = intArrayOf(1,2,3,4,5,6,7,8)
    println(arr3.size)
    println(arr3.count())
    println(arr3.contains(5))
    println(arr3.indexOf(2))
    println(arr3.joinToString("-"))
    println(arr3.reversedArray())

    //3.Function ไปสร้างอยู่ข้างนอก fun main()

    //4.exception การจัดการกับข้อผิดพลาด
    try{
        var t:Int = 10
        var c:Int = 1
//        if(c == 1){
//                throw Exception("Number One")
//        }
        var result = t/c
        println(result)
    }
    catch(e:ArithmeticException){
        println("Not divided by zero")
    }
    catch(e:Exception){
        println("Error : $e.message")
    }
    finally {
        println("ขึ้นตลอดไม่ว่าจะเป็นยังไง")
    }







}

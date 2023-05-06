# GAME SIMPLICITY
Game untuk melakukan kehidupan sehari - hari seperti bekerja, makan, olahraga dan lain - lain.

## SetUp
Untuk menjalankan gamenya kita membutuhkan: 
1. JDK SE Compiler
2. Text Editor
3. Git
4. CLI

Sebelum memainkan Game Simplicity kita memerlukan pull dari folder git :
1. Membuat folder tempat menyimpan folder game
2. Inisialisasi git di folder tersebut
`git init`
3. Kemudian 
`git remote add origin https://github.com/syahrialalzaidan/Tugas-Besar-OOP-Kel13.git `
4. Kemudian melakukan pull dari main
`git pull origin main`
5. Kemudian dilakukan setting di JAVA PROJECTS untuk menambahkan depedency <br>![image](https://user-images.githubusercontent.com/99486521/236618050-c3bf99f7-07c0-4655-89d4-8eb8192ad111.png)
6. Tambahkan file jar gson pada folder dependencies



## Cara Menjalankan Program
ini untuk compile file java :
` javac -d bin -cp dependency/gson-2.8.6.jar NetBeans/src/*.java `

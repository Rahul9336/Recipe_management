Mainou’s Recipe Lab(Using Spring MVC)

Step 1:

Download Project Folder and UNZIP

Step 2:

Open Eclipse Java EE IDE(Latest Verson)

Put Both UNZIP File Into Eclipse WorkSpace Folder

Open Eclipse and Import Project as a Maven Existing Project.

First Import com.mainou_recipe_lab

then Import lab_frontView

Now Maven->Update Project

Wait for Updation.............

Step 3:

Go to com.mainou_recipe_lab->src/main/java/recipe_lab.database_config

open HibernateConfig File and Read Instruction Carefully(Setup database detail(URl,Drivername,Username,Password)).

Dont forget to add driver.

Now Check the Project is Ready to Run or not By testing

Go to com.mainou_recipe_lab->src/main/java/recipe_lab

open App.java and Uncomment test method and Run the java file as junit test.

If Everyting Go well You see the Query that created by Hibernate.

After Successfully Testing the Backend

Step 4:

Open lab_frontView and Go to lab_frontView/src/main/java/lab_frontView

and open RecipeController.java

and Go to Line No.74 and Change it according to your System Folder otherwise You may not able to fetch image.

After All this Now You Ready For Exceution

run ->lab_frontView-> Run As ->Run on Server

Set Server Detail(Prefer Server Tomcat V8.0)

Thank You
Best Regards
Rahul Gupta
rahulgupta9336@gmail.com
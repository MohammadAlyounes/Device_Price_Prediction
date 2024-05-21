# Device_Price_Prediction
Given an input payload (JSON) included with specs of the device (features) it will get an output as API. (There are more).

The project has two components: Python project and Java project.

1) Python project included model development and data cleaning using Jupyter Notebook.

2) For the Java project I built a Rest API (using Spring boot and H2 database) to handle the prediction service provided by the Python project. (All necessary code inside src/main/moh):  
   
       2.1) controller folder included with code to build rest APIs endpoint with business logic.  
       2.2) model folder included with code of schema of our data to use in some endpoints.  
       2.3) repository folder included with code for the interface of our database.  



Some Further improvement(in progress):
1) More collection to train data.
2) More exploratory data analysis such as correlation matrix and feature importance plots.
3) Try more open choices of ML algorithms such as Xgboost.

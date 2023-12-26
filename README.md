# EmployeeWise

## Runing the project

### To run the code locally follow below steps,

1.  #### Download the zip file and extract the file
2.  #### Install all the dependency
3.  #### Run the project

## Database Setup

#### Create a new database employees

## API(routes)

1. ### POST _api/addEmployee_

   ### To add new employee

   #### - Request Body (JSON)

   ##### _Add employee_name, phone_number,email, id, reports_to and profile_image_

   #### - Response Body(JSON)

   ##### _Request body is returned back in the JSON format_

2. ### GET _api/employees_

   ### To get all employees list

   #### - No request body

   #### - Response Body(JSON array of objects)

   ##### _Returns the list of employees_

3. ### DELETE _api/employees/{employeeId}_

   ### To delete an employee

   #### Path Parameter is _employee id_

   #### - Response(JSON)

   ##### _A confirmation messsage_

4. ### PUT _api/updateEmployee_

   ### To update an employee

   #### Path Parameter is _employee id_

   #### - Request Body(JSON)

   ##### _*Add employee_name, phone_number,email, id, reports_to and profile_image*_

   #### - Response(JSON)

   ##### _Updated employee_

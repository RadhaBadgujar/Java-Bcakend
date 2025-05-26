// Value	State	Description
// 0	UNSENT	Client has been created. open() not called yet.
// 1	OPENED	open() has been called.
// 2	HEADERS_RECEIVED	send() has been called, and headers and status are available.
// 3	LOADING	Downloading; responseText holds partial data.
// 4	DONE	The operation is complete.
console.log(" welcome in Ajax tutorial");

let fetchBtn=document.getElementById('fetchBtn');
fetchBtn.addEventListener('click',buttonClickHandler)
function buttonClickHandler(){
//instantiate an xhr object
const xhr =new XMLHttpRequest();
//open the object, true means-non blocking next process continuesly run in background
xhr.open('GET','https://jsonplaceholder.typicode.com/todos/1',true) ;
//what to do on progress (optional)
xhr.onprogress=function(){
console.log('on progress');
}
//old function
xhr.onreadystatechange=function(){
    console.log("ready state is" +this.readyState)
}
//what to do when response is ready,xhr na ready state ma come
xhr.onload=function(){
    if(this.status===200){
    console.log(this.responseText)
    }else{
        console.error("some error occured")
    }
}
//send the request
xhr.send();
}

//popbtn
// let popBtn=document.getElementById('popBtn');
// popBtn.addEventListener('click',popHandler)
// function popHandler(){
//     console.log('you have clicked pop Handler')
//     const xhr =new XMLHttpRequest();
//     xhr.open('GET','https://dummy.restapiexample.com/api/v1/employee/1',true) ;
//     //what to do on progress (optional)
//     xhr.onprogress=function(){
//     console.log('on progress');
//     }
//     xhr.onload=function(){
//         if(this.status===200){
//       let obj=JSON.parse(this.responseText)
//       console.log(obj)
//         }else{
//             console.error("some error occured")
//         }
//     }
// xhr.send();
// console.log('Employeee Data')
// }
//curl --location 'https://dummy.restapiexample.com/api/v1/employee/1'

// Get the button element
let popBtn = document.getElementById('popBtn');

// Add an event listener to the button
popBtn.addEventListener('click', popHandler);

function popHandler() {
    console.log('You have clicked pop Handler');

    // Create a new XMLHttpRequest object
    const xhr = new XMLHttpRequest();

    // Initialize a GET request to the API endpoint
    xhr.open('GET', 'https://dummy.restapiexample.com/api/v1/employee/1', true);

    // Optional: What to do during progress
    xhr.onprogress = function () {
        console.log('Fetching employee data... (on progress)');
    };

    // What to do when the request has completed successfully
    xhr.onload = function () {
        if (this.status === 200) {
            // Parse and log the response
            let obj = JSON.parse(this.responseText);
            console.log('Employee Details:', obj);
        } else {
            console.error('Some error occurred while fetching data');
        }
    };

    // What to do in case of an error
    xhr.onerror = function () {
        console.error('Request failed');
    };

    // Send the request
    xhr.send();
    console.log('Employee Data request sent');
}

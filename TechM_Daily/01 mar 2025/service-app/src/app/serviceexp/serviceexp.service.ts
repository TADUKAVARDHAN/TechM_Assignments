import { Injectable } from "@angular/core";
@Injectable({
    providedIn: 'root'
})
export class Student{
    private slist:Array<any>=[];
    constructor(){
        this.slist=[{name:'Bhanu',age:20,city:"Hyderabad",dob:"16-06-2004"}];
    }
    returnStdData():Array<any>{
        return this.slist;
    }
    addStdData(i:any):void{
        this.slist.push(i);
    }
}
import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  @Output() searchEmitterEvent: any;
  searchString: string;
  
  constructor() {
    this.searchEmitterEvent = new EventEmitter();
   }

  ngOnInit() {
  }
  filterData() {
    this.searchEmitterEvent.emit(this.searchString);
  }
}

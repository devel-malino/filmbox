import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilmboxComponent } from './filmbox.component';

describe('FilmboxComponent', () => {
  let component: FilmboxComponent;
  let fixture: ComponentFixture<FilmboxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilmboxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilmboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

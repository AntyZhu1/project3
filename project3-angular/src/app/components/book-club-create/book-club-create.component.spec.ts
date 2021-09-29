import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookClubCreateComponent } from './book-club-create.component';

describe('BookClubCreateComponent', () => {
  let component: BookClubCreateComponent;
  let fixture: ComponentFixture<BookClubCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookClubCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookClubCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

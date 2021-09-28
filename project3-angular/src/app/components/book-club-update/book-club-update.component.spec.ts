import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookClubUpdateComponent } from './book-club-update.component';

describe('BookClubUpdateComponent', () => {
  let component: BookClubUpdateComponent;
  let fixture: ComponentFixture<BookClubUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookClubUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookClubUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

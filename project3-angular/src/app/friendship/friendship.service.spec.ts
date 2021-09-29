import { TestBed } from '@angular/core/testing';

import { FriendshipService } from 'src/app/friendship/friendship.service';


describe('UserService', () => {
  let service: FriendshipService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FriendshipService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
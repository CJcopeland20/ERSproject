import { TestBed } from '@angular/core/testing';

import { LoginServiceservice } from './login.service';

describe('LoginServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginServiceservice = TestBed.get(LoginServiceservice);
    expect(service).toBeTruthy();
  });
});

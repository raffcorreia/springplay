import {TestBed} from '@angular/core/testing';

import {SqlInjectionService} from './sql-injection.service';

describe('SqlInjectionService', () => {
    beforeEach(() => TestBed.configureTestingModule({}));

    it('should be created', () => {
        const service: SqlInjectionService = TestBed.get(SqlInjectionService);
        expect(service).toBeTruthy();
    });
});

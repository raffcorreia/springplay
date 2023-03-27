//
//  main.cpp
//  PrimeC
//
//  Created by Rafael Correia on 2022-05-21.
//

#include <iostream>
#include <cmath>
#include <chrono>

using namespace std;
using namespace std::chrono;

typedef high_resolution_clock Clock;
typedef Clock::time_point ClockTime;


const unsigned long long int BIG_INT_ZERO = 0;
const unsigned long long int BIG_INT_ONE = 1;
const unsigned long long int BIG_INT_TWO = 2;
const unsigned long long int BIG_INT_THREE = 3;
const unsigned long long int BIG_INT_FIVE = 5;
const unsigned long long int BIG_INT_SIX = 6;


bool isPrime(unsigned long long int n) {
    if (n == BIG_INT_TWO || n == BIG_INT_THREE)
        return true;

    if (n <= BIG_INT_ONE || n % BIG_INT_TWO == BIG_INT_ZERO || n % BIG_INT_THREE == BIG_INT_ZERO)
        return false;
    
    unsigned long long int sqrtOfN = sqrt(n);

    for (unsigned long long int i = BIG_INT_FIVE; i <= sqrtOfN; i += BIG_INT_SIX)
    {
        if (n % i == BIG_INT_ZERO || n % (i + BIG_INT_TWO) == BIG_INT_ZERO)
            return false;
    }

    return true;
}

void printExecutionTime(ClockTime start_time, ClockTime end_time) {
    auto execution_time_ns = duration_cast<nanoseconds>(end_time - start_time).count();
    auto execution_time_ms = duration_cast<microseconds>(end_time - start_time).count();
    auto execution_time_sec = duration_cast<seconds>(end_time - start_time).count();
    auto execution_time_min = duration_cast<minutes>(end_time - start_time).count();
    auto execution_time_hour = duration_cast<hours>(end_time - start_time).count();

    cout << "\nExecution Time: ";
    if(execution_time_hour > 0)
    cout << "" << execution_time_hour << " Hours, ";
    if(execution_time_min > 0)
    cout << "" << execution_time_min % 60 << " Minutes, ";
    if(execution_time_sec > 0)
    cout << "" << execution_time_sec % 60 << " Seconds, ";
    if(execution_time_ms > 0)
    cout << "" << execution_time_ms % long(1E+3) << " MicroSeconds, ";
    if(execution_time_ns > 0)
    cout << "" << execution_time_ns % long(1E+6) << " NanoSeconds, ";
}

int main(int argc, const char * argv[]) {
    ClockTime start_time = Clock::now();
    unsigned long long number;
//    number = 32361122672259149;
//    number = 11111111111111111111ULL;
    number = 2305843009213693951ULL;
//    number = 18446744073709551615ULL; //Maximum unsigned long long int
    
    std::cout << "The number (" << number << ") tested is prime = " << isPrime(number) << "\n";
    
    ClockTime end_time = Clock::now();

    printExecutionTime(start_time, end_time);
    
    return 0;
}

/*
Java results

Validated 32361122672259149 as prime is true in 2seconds
Validated 59604644783353249 as prime is true in 3seconds
Validated 1111111111111111111 as prime is true in 16seconds
Validated 2305843009213693951 as prime is true in 23seconds
 
*/

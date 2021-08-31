add_library("20210529_Next_Permutation" solution.cpp)

add_executable("20210529_Next_Permutation_Test" solution_test.cpp)
target_link_libraries("20210529_Next_Permutation_Test" PRIVATE "20210529_Next_Permutation" GTest::gtest GTest::gtest_main)
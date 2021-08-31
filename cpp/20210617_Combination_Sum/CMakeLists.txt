add_library("20210617_Combination_Sum" solution.cpp)

add_executable("20210617_Combination_Sum_Test" solution_test.cpp)
target_link_libraries("20210617_Combination_Sum_Test" PRIVATE "20210617_Combination_Sum" GTest::gtest GTest::gtest_main)
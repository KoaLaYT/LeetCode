add_library("20210529_Divide_Two_Integers" solution.cpp)

add_executable("20210529_Divide_Two_Integers_Test" solution_test.cpp)
target_link_libraries("20210529_Divide_Two_Integers_Test" PRIVATE "20210529_Divide_Two_Integers" GTest::gtest GTest::gtest_main)
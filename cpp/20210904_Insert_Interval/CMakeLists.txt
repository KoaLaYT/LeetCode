add_library("20210904_Insert_Interval" solution.cpp)

add_executable("20210904_Insert_Interval_Test" solution_test.cpp)
target_link_libraries("20210904_Insert_Interval_Test" PRIVATE "20210904_Insert_Interval" GTest::gtest GTest::gtest_main)
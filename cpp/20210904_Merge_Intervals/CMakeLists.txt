add_library("20210904_Merge_Intervals" solution.cpp)

add_executable("20210904_Merge_Intervals_Test" solution_test.cpp)
target_link_libraries("20210904_Merge_Intervals_Test" PRIVATE "20210904_Merge_Intervals" GTest::gtest GTest::gtest_main)
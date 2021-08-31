add_library("20210528_4Sum" solution.cpp)

add_executable("20210528_4Sum_Test" solution_test.cpp)
target_link_libraries("20210528_4Sum_Test" PRIVATE "20210528_4Sum" GTest::gtest GTest::gtest_main)
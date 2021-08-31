add_library("20210615_Count_and_Say" solution.cpp)

add_executable("20210615_Count_and_Say_Test" solution_test.cpp)
target_link_libraries("20210615_Count_and_Say_Test" PRIVATE "20210615_Count_and_Say" GTest::gtest GTest::gtest_main)
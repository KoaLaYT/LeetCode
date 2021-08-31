add_library("20210527_3Sum_Closest" solution.cpp)

add_executable("20210527_3Sum_Closest_Test" solution_test.cpp)
target_link_libraries("20210527_3Sum_Closest_Test" PRIVATE "20210527_3Sum_Closest" GTest::gtest GTest::gtest_main)
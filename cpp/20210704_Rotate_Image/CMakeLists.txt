add_library("20210704_Rotate_Image" solution.cpp)

add_executable("20210704_Rotate_Image_Test" solution_test.cpp)
target_link_libraries("20210704_Rotate_Image_Test" PRIVATE "20210704_Rotate_Image" GTest::gtest GTest::gtest_main)
# Important!!!
# You may need to give permission to create the /obj directory.
# You can also just create it yourself.

JAVAC := javac
JAVA := java

SRC_DIR := src
OBJ_DIR := obj
MAIN_CLASS := src.Main

SOURCES := $(wildcard $(SRC_DIR)/*.java)
BUILD_STAMP := $(OBJ_DIR)/.build-stamp

.PHONY: all run log clean rebuild re

all: $(BUILD_STAMP)

$(BUILD_STAMP): $(SOURCES) | $(OBJ_DIR)
	$(JAVAC) -d $(OBJ_DIR) $(SOURCES)
	touch $(BUILD_STAMP)

$(OBJ_DIR):
	mkdir -p $(OBJ_DIR)

run: all
	cd $(SRC_DIR) && $(JAVA) -cp ../$(OBJ_DIR) $(MAIN_CLASS)

log: all
	cd $(SRC_DIR) && $(JAVA) -cp ../$(OBJ_DIR) $(MAIN_CLASS) > "../out.txt"

clean:
	rm -rf $(OBJ_DIR)
	rm -f out.txt

rebuild: clean all

re: rebuild

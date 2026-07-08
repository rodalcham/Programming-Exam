JAVAC := javac
JAVA := java

SRC_DIR := src
OBJ_DIR := obj
MAIN_CLASS := src.Main

SOURCES := $(wildcard $(SRC_DIR)/*.java)
CLASSES := $(SOURCES:$(SRC_DIR)/%.java=$(OBJ_DIR)/src/%.class)

.PHONY: all run clean rebuild

all: $(CLASSES)

$(OBJ_DIR)/src/%.class: $(SRC_DIR)/%.java | $(OBJ_DIR)
	$(JAVAC) -d $(OBJ_DIR) $(SOURCES)

$(OBJ_DIR):
	mkdir -p $(OBJ_DIR)

run: all
	cd $(SRC_DIR) && $(JAVA) -cp ../$(OBJ_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(OBJ_DIR)

rebuild: clean all

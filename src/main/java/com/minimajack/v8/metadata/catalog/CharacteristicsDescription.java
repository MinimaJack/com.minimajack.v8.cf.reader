package com.minimajack.v8.metadata.catalog;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.type.TypeValue;
import com.minimajack.v8.metadata.external.unknown.UnkIntUuid;

/*
 *
 * {"#",fe839d42-d094-40ba-b903-75bccc21ba30,
 * {1,
 * {1,782cb93d-36e6-4923-b2b6-75caa3459cd6},
 * {1,7ea067ad-faa0-4077-a922-1d0643f0be63},
 * {0,
 * {-8}
 * },
 * {0,
 * {0,68fae050-a374-46b1-b4c3-467a1d94c991}
 * },
 * {0,
 * {0,3c3c5e9f-0d3d-4554-9bac-4b32d3e24ba2}
 * },
 * {0,
 * {-4}
 * },
 * {"#",5c14e26f-099b-4d37-84a6-b433d87400da,
 * {0,fc1d5c1f-385f-493f-a538-f80a12c7cb6f,aa8d4cbb-a143-495a-842f-6db6ca18e8e1}
 * },
 * {0,
 * {-8}
 * }
 * }
 * }
 */
@V8Class
public class CharacteristicsDescription {

  public Integer version;

  public UnkIntUuid unk1;
  public UnkIntUuid unk2;
  public CharacteristicsStrObject unk3;
  public CharacteristicsStrObject unk4;
  public CharacteristicsStrObject unk5;
  public CharacteristicsStrObject unk6;
  public TypeValue unk7;
  public CharacteristicsStrObject unk8;
}
